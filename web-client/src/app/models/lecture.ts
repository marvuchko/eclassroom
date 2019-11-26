import { Video } from './video';
import { User } from './user';

export class Lecture {
    id: string;
    createdAt: string;
    updatedAt: string;
    title: string;
    description: string;
    videos: Video[];
    tutor: User;
}
