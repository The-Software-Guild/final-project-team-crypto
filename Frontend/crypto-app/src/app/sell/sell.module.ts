import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SellRoutingModule } from './sell-routing.module';
import { SellPageComponent } from './sell-page/sell-page.component';


@NgModule({
  declarations: [
    SellPageComponent
  ],
  imports: [
    CommonModule,
    SellRoutingModule
  ]
})
export class SellModule { }
