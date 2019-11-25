import { VideoThread } from './video-thread';

export class Video {
  id: string;
  createdAt: string;
  updatedAt: string;
  title: string;
  videoUrl: string;
  thumbnailUrl: string;
  durationInSeconds: number;
  threads: VideoThread[];
}
