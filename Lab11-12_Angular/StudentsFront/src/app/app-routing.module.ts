import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StudentsComponent } from './students/students.component';
import { StudentDetailComponent } from './student-detail/student-detail.component';
import { Component } from '@angular/core';
import { AboutComponent } from './about/about.component';
 
const routes: Routes = [
  { path: 'about', component: AboutComponent },
  { path: 'students', component: StudentsComponent },
  { path: 'detail/:id', component: StudentDetailComponent },
  { path: '', redirectTo: '/students', pathMatch: 'full' }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
  

})
export class AppRoutingModule {
  
 }
