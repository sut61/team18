import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ContractComponent } from './contract/contract.component';
import { EditContractComponent } from './edit-contract/edit-contract.component';
import { LoginAddminComponent } from './login-addmin/login-addmin.component';
import { MainAdminComponent } from './main-admin/main-admin.component';
import { LoginMaidComponent } from './login-maid/login-maid.component';
import { LoginCustomerComponent } from './login-customer/login-customer.component';
const routes: Routes = [
  {path:'' , component:LoginAddminComponent},
  {path:'contract' , component:ContractComponent},
  {path:'mainAdmin' , component:MainAdminComponent},
  {path:'editcontract' , component:EditContractComponent},
  {path:'loginMaid' , component:LoginMaidComponent},
  {path:'loginCus' , component:LoginCustomerComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
