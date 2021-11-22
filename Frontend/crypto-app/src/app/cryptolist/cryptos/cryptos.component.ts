import { Component, OnInit } from '@angular/core';

import { CryptosService } from './cryptos.service'

import { Crypto } from './cryptos'
import { tick } from '@angular/core/testing';

@Component({
  selector: 'app-cryptos',
  templateUrl: './cryptos.component.html',
  providers: [CryptosService],
  styleUrls: ['./cryptos.component.css']
})
export class CryptosComponent implements OnInit {
  coin!: Crypto;
  btcPrice!: string;
  ethPrice!: string;
  bnbPrice!: string;
  adaPrice!: string;
  solPrice!: string;
  dogePrice!: string;

  constructor(private cService: CryptosService) { }

  ngOnInit(): void {
    this.getPrice('BTC');
    this.getPrice('ETH');
    this.getPrice('BNB');
    this.getPrice('ADA');
    // this.getPrice('SOL');
    // this.getPrice('DOGE');
  }

  getPrice(ticker: string): void {
    this.cService.getPrice(ticker).subscribe(price => {
      this.coin = price;

      switch (ticker){
        case 'BTC':
          this.btcPrice = this.coin['Realtime Currency Exchange Rate']['5. Exchange Rate'];
          break;
        case 'ETH':
          this.ethPrice = this.coin['Realtime Currency Exchange Rate']['5. Exchange Rate'];
          break;
        case 'BNB':
          this.bnbPrice = this.coin['Realtime Currency Exchange Rate']['5. Exchange Rate'];
          break;
        case 'ADA':
          this.adaPrice = this.coin['Realtime Currency Exchange Rate']['5. Exchange Rate'];
          break;
        case 'DOGE':
          this.dogePrice = this.coin['Realtime Currency Exchange Rate']['5. Exchange Rate'];
          break;
        default:
          break;
      }

    });
  }

}
