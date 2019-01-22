import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ContractComponent } from './contract/contract.component';
import { EditContractComponent } from './edit-contract/edit-contract.component';
import { LoginAddminComponent } from './login-addmin/login-addmin.component';
import { MainAdminComponent } from './main-admin/main-admin.component';
const routes: Routes = [
  {path:'' , component:LoginAddminComponent},
  {path:'contract' , component:ContractComponent},
  {path:'mainAdmin' , component:MainAdminComponent},
  {path:'editcontract' , component:EditContractComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
