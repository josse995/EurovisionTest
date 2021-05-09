import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { NgxPaginationModule } from 'ngx-pagination';
import { CitiesListComponent } from './components/cities-list/cities-list.component'
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatTableModule } from '@angular/material/table';
import { MatFormFieldModule, MatLabel } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { HomeComponent } from './components/home/home.component'

@NgModule({
  declarations: [
    AppComponent,
    CitiesListComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgxPaginationModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatPaginatorModule,
    MatTableModule,
    MatFormFieldModule,
    MatInputModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
