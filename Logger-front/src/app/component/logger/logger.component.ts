import {Component, OnInit, ViewChild} from '@angular/core';
import {LogService} from "../../core/service/log.service";
import {Log} from "../../core/models/Log";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {AppNames} from "../../core/models/AppNames";

@Component({
  selector: 'app-logger',
  templateUrl: './logger.component.html',
  styleUrls: ['./logger.component.css']
})
export class LoggerComponent implements OnInit {

  public logs: Log[] = [];
  public apps: AppNames = {names: []};
  dataSource = new MatTableDataSource<Log>(this.logs);
  displayedColumns: string[] = ['id', 'app', 'message', 'userId', 'createdAt'];
  @ViewChild(MatPaginator, {static: false}) paginator!: MatPaginator;
  selectedApp: string = "";

  constructor(private logService: LogService) {
  }

  ngOnInit(): void {
    this.logService.getAllAppsName().subscribe({
      next: value => {
        this.apps = value
      },
      error: err => {
        console.log(err);
      }
    })

    this.getAllLogs()
  }

  getAllLogs() {
    this.logService.getAll().subscribe({
      next: value => {
        this.logs = value
        for (const element of this.logs) {
          if (element.createdAt)
            element.createdAt = element.createdAt[2] + "/" + element.createdAt[1] + "/" + element.createdAt[0];
        }
        this.dataSource = new MatTableDataSource(this.logs)
        this.dataSource.paginator != this.paginator;
      },
      error: err => {
        console.log(err);
      }
    })
  }


  showLog() {
    this.logService.getLogByAppName(this.selectedApp).subscribe({
      next: value => {
        this.logs = value
        for (const element of this.logs) {
          if (element.createdAt)
            element.createdAt = element.createdAt[2] + "/" + element.createdAt[1] + "/" + element.createdAt[0];
        }
        this.dataSource = new MatTableDataSource(this.logs)
        this.dataSource.paginator != this.paginator;
      },
      error: err => {
        console.log(err);
      }
    })
  }
}
