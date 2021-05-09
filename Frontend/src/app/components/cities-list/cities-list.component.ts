import { Component, OnInit } from '@angular/core';
import { CitiesService } from 'src/app/services/cities.service';
import { PageEvent } from '@angular/material/paginator'
import { MatTableDataSource } from '@angular/material/table'
import { City } from 'src/app/services/city';

@Component({
  selector: 'app-cities-list',
  templateUrl: './cities-list.component.html',
  styleUrls: ['./cities-list.component.css']
})
export class CitiesListComponent implements OnInit {

  cities: MatTableDataSource<City>;

  //MatPaginator Inputs
  pageIndex: number = 0;
  length: number;
  pageSize: number = 5;
  pageSizeOptions: number[] = [5, 10, 25, 100];

  // MatPaginator Output
  pageEvent: PageEvent

  displayedColumns: string[] = ['id', 'name']

  constructor(private citiesService: CitiesService) { }

  ngOnInit(): void {
    this.cities = new MatTableDataSource();
    this.retrieveCities();
  }

  private retrieveCities() {
    this.citiesService.getAllCities(this.pageIndex, this.pageSize).subscribe(
      response => {
        const { content, totalElements, totalPages } = response;
        this.cities.data = content;
        this.length = totalElements;
        console.log(response);
      },
      error => {
        console.log(error);
      }
    )
  }

  handlePageChange(event: PageEvent): PageEvent {
    this.pageIndex = event.pageIndex;
    this.pageSize = event.pageSize;
    this.retrieveCities();
    return event;
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.cities.filter = filterValue.trim().toLowerCase();

    if (this.cities.paginator) {
      this.cities.paginator.firstPage();
    }
  }

}
