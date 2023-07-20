import { Injectable } from '@angular/core';
import {ApiService} from "./api.service";
import {Observable} from "rxjs";
import {Log} from "../models/Log";
import {AppNames} from "../models/AppNames";

@Injectable({
  providedIn: 'root'
})
export class LogService {

  constructor(private api: ApiService) { }

  getAllAppsName(): Observable<AppNames> {
    return this.api.get('api/v1/log/apps');
  }

  getLogById(id: number): Observable<Log> {
    return this.api.get(`api/v1/log/${id}`);
  }

  getLogByAppName(name: string): Observable<Log[]> {
    return this.api.get(`api/v1/log/name/${name}`);
  }

  getAll(): Observable<Log[]> {
    return this.api.get(`api/v1/log/all`);
  }
}
