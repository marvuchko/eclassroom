import { VideoThreadMessage } from './video-thread-message';

export class VideoThread {
  id: string;
  createdAt: string;
  updatedAt: string;
  title: string;
  messages: VideoThreadMessage[];
}
