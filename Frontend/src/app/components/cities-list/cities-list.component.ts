import { Component, OnInit } from '@angular/core';
import { CitiesService } from 'src/app/services/cities.service';

@Component({
  selector: 'app-cities-list',
  templateUrl: './cities-list.component.html',
  styleUrls: ['./cities-list.component.css']
})
export class CitiesListComponent implements OnInit {

  content: any;

  page = 1;
  count = 0;
  pageSize = 3;
  pageSizes = [3, 6, 9];

  constructor(private citiesService: CitiesService) { }

  ngOnInit(): void {
    this.retrieveCities();
  }

  retrieveCities() {

    this.citiesService.getAllCities(this.page, this.pageSize).subscribe(
      response => {
        const { content, totalElements, totalPages } = response;
        this.content = content;
        this.count = totalElements;
        console.log(response);
      },
      error => {
        console.log(error);
      }
    )
  }

  handlePageChange(event) {
    this.page = event;
    this.retrieveCities();
  }

  handlePageSizeChange(event) {
    this.pageSize = event.target.value;
    this.page = 1;
    this.retrieveCities();
  }

}
