import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class DadosService {
  private apiUrl = 'lol\db.json';

  constructor(private http: HttpClient) {}

  getDados(): Observable<any> {
    return this.http.get<any>(this.apiUrl).pipe(
      tap(data => console.log('Dados do JSON:', data)),
      catchError(this.handleError)
    );
  }

  private handleError(error: any) {
    console.error('Erro ao carregar dados:', error);
    return throwError('Erro ao carregar dados. Por favor, verifique o console para mais detalhes.');
  }
}