import { VideoThreadMessage } from './video-thread-message';

export class VideoThread {
  id: string;
  createdAt: string;
  updatedAt: string;
  title: string;
  videoTimestamp: number;
  messages: VideoThreadMessage[];
  authorName: string;
  authorEmail: string;
}
