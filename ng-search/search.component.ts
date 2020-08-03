import {Component} from '@angular/core';

interface Type {
  value: string;
  viewValue: string;
}

/**
 * @title Basic select
 */
@Component({
  selector: 'search',
  templateUrl: 'search.html',
})
export class SearchDemo {
  types: Type[] = [
    {value: 'NAME', viewValue: 'Name'},
    {value: 'IC', viewValue: 'IC'}
  ];
}