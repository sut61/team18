import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ContractComponent } from './contract/contract.component';
const routes: Routes = [
  {path:'contract' , component:ContractComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
