import { VideoThread } from '../models/video-thread';

const CUE_DURATION = 1;

export const getCuePoints = (videoThreads: VideoThread[], cueDuration = CUE_DURATION): TextTrackCue[] => {
  const cues = videoThreads.reduce((acc, curr) => {
    const from = curr.videoTimestamp;
    const to = from + cueDuration;
    const cue = new VTTCue(from, to, 'cue');
    acc.push(cue);
    return acc;
  }, new Array<TextTrackCue>());
  return cues;
}
