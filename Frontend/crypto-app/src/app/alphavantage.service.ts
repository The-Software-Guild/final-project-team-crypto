import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AlphavantageService {
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': 'my-auth-token' }),
  };
  constructor(
    private key: '72984853f9msh806c569f9844225p1fea70jsnb1f3cbecba8a',
    private http: HttpClient
  ) { }
  public getSimpleJson(): Observable<any> {
    return this.http.get('alpha-vantage.p.rapidapi.com/query?from_currency=DOGE&function=CURRENCY_EXCHANGE_RATE&to_currency=USD&apikey=' + this.key);
  }
}
