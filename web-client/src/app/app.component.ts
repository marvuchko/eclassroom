import { Component } from '@angular/core';
import { UpdaterService } from './core/updater.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'eclassroom';

  constructor(private updater: UpdaterService) {
    this.updater.init();
  }
}
