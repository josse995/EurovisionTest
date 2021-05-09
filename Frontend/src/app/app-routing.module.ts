import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CitiesListComponent } from './components/cities-list/cities-list.component';
import { HomeComponent } from './components/home/home.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'cities', component: CitiesListComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
