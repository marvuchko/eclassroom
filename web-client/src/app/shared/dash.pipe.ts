import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'dash'
})
export class DashPipe implements PipeTransform {

  transform(value: any, ...args: any[]): any {
    if (value === null || value === undefined) {
      return args[0] || '-';
    } else {
      return value;
    }
  }

}
