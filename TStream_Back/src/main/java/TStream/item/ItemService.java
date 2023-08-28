package TStream.item;

import TStream.external.model.Clip;
import TStream.external.model.Stream;
import TStream.external.model.Video;
import TStream.external.TwitchService;
import TStream.model.TypeGroupedItemList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private static final int SEARCH_RESULT_SIZE = 20;

    private final TwitchService twitchService;

    public ItemService(TwitchService twitchService) {
        this.twitchService = twitchService;
    }

    public TypeGroupedItemList getItems(String gameId) {
        List<Video> videos = twitchService.getVideos(gameId, SEARCH_RESULT_SIZE);
        List<Clip> clips = twitchService.getClips(gameId, SEARCH_RESULT_SIZE);
        List<Stream> streams = twitchService.getStreams(List.of(gameId), SEARCH_RESULT_SIZE);
        return new TypeGroupedItemList(gameId, streams, videos, clips);
    }

}