import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BuyRoutingModule } from './buy-routing.module';
import { BuyPageComponent } from './buy-page/buy-page.component';


@NgModule({
  declarations: [
    BuyPageComponent
  ],
  imports: [
    CommonModule,
    BuyRoutingModule
  ]
})
export class BuyModule { }
