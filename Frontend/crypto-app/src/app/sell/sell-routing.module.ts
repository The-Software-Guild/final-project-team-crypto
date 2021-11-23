import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { SellPageComponent } from './sell-page/sell-page.component';

const routes: Routes = [{
  path: 'sell', component: SellPageComponent
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SellRoutingModule { }
