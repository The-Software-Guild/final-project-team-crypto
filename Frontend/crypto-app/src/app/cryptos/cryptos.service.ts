import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';


import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';

import { Crypto } from './cryptos';

const httpOptions = {
  headers: new HttpHeaders({
    'x-rapidapi-host':  'alpha-vantage.p.rapidapi.com',
    'x-rapidapi-key': '72984853f9msh806c569f9844225p1fea70jsnb1f3cbecba8a'
  })
};


@Injectable({
  providedIn: 'root'
})

export class CryptosService {
  cryptoUrl = 'https://alpha-vantage.p.rapidapi.com/query?from_currency=BTC&function=CURRENCY_EXCHANGE_RATE&to_currency=USD&apikey=0NZ3U3VVSQNFIB8J';
  constructor(private http: HttpClient){}
  
  /** GET heroes from the server */
  getBTC(): Observable<Crypto[]> {
    return this.http.get<Crypto[]>(this.cryptoUrl, httpOptions);
  }
}
