import { City } from "./city";

export interface CityByPageAndSize {
  content: City[];
  totalPages: number;
  totalElements: number;
}