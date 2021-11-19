import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HttpClientModule } from '@angular/common/http';
import { HomeModule } from './home/home.module';
import { AccountModule } from './account/account.module';
import { AboutusModule } from './aboutus/aboutus.module';
import { SearchBarComponent } from './search-bar/search-bar.component';
import { CryptListComponent } from './crypt-list/crypt-list.component';
import { CryptosComponent } from './cryptos/cryptos.component';

@NgModule({
  declarations: [
    AppComponent,
    SearchBarComponent,
    CryptListComponent,
    CryptosComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    HomeModule,
    AccountModule,
    AboutusModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
