import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { BuyPageComponent } from './buy-page/buy-page.component';

const routes: Routes = [
  {path: 'buy', component: BuyPageComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BuyRoutingModule { }
