import { Component, OnInit } from '@angular/core';

import { CryptosService } from './cryptos.service'

import { Crypto } from './cryptos'

@Component({
  selector: 'app-cryptos',
  templateUrl: './cryptos.component.html',
  providers: [CryptosService],
  styleUrls: ['./cryptos.component.css']
})
export class CryptosComponent implements OnInit {
  BTC!: Crypto;

  constructor(private cService: CryptosService) { }

  ngOnInit(): void {
    this.getPrice('BTC');
  }

  getPrice(ticker: string): void {
    this.cService.getPrice(ticker).subscribe(price => {
      this.BTC = price;

      console.log(this.BTC['Realtime Currency Exchange Rate']['5. Exchange Rate'])
      

    });
  }

}
