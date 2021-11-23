import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CryptolistRoutingModule } from './cryptolist-routing.module';
import { CryptosComponent } from './cryptos/cryptos.component';


@NgModule({
  declarations: [
    CryptosComponent
  ],
  imports: [
    CommonModule,
    CryptolistRoutingModule
  ]
})
export class CryptolistModule { }
