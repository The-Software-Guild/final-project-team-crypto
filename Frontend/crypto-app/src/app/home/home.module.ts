import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { HomePageComponent } from './home-page/home-page.component';

import { CryptolistRoutingModule } from '../cryptolist/cryptolist-routing.module';
import { CryptosComponent } from '../cryptolist/cryptos/cryptos.component'



@NgModule({
  declarations: [
    HomePageComponent,
    CryptosComponent
  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
    CryptolistRoutingModule
  ]
})
export class HomeModule { }
