import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./component/home/home.component";
import {LoggerComponent} from "./component/logger/logger.component";

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'logger', component: LoggerComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
