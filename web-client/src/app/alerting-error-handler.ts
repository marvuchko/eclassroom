import { Injectable, ErrorHandler } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class AlertingErrorHandler extends ErrorHandler {

  handleError(error: any) {
    super.handleError(error);
    alert(error.message);
  }

}
