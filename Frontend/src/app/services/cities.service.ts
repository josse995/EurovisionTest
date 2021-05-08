import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { CityByPageAndSize } from './cityByPageAndSize';

@Injectable({ providedIn: 'root' })
export class CitiesService {
  private apiServerUrl = environment.apiBaseUrl;


  constructor(private http: HttpClient) { }

  public getAllCities(page: number, size: number): Observable<CityByPageAndSize> {
    return this.http.get<CityByPageAndSize>(`${this.apiServerUrl}/api/queryByPage?page=${page}&size=${size}`);
  }
}
