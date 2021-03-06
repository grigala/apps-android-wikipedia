package org.wikipedia.feed;

import android.content.Context;
import android.support.annotation.NonNull;

import org.wikipedia.feed.aggregated.AggregatedFeedContentClient;
import org.wikipedia.feed.announcement.AnnouncementClient;
import org.wikipedia.feed.becauseyouread.BecauseYouReadClient;
import org.wikipedia.feed.continuereading.ContinueReadingClient;
import org.wikipedia.feed.mainpage.MainPageClient;
import org.wikipedia.feed.offline.OfflineCompilationClient;
import org.wikipedia.feed.random.RandomClient;
import org.wikipedia.feed.searchbar.SearchClient;
import org.wikipedia.util.DeviceUtil;

import static org.wikipedia.util.ReleaseUtil.isPreBetaRelease;

class FeedCoordinator extends FeedCoordinatorBase {

    FeedCoordinator(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void buildScript(int age) {
        boolean online = DeviceUtil.isOnline();

        conditionallyAddPendingClient(new SearchClient(), age == 0);
        conditionallyAddPendingClient(new OfflineCompilationClient(), age == 0 && !online && isPreBetaRelease());
        conditionallyAddPendingClient(new AnnouncementClient(), age == 0 && online);
        conditionallyAddPendingClient(new AggregatedFeedContentClient(), online);
        addPendingClient(new ContinueReadingClient());

        // TODO: enable this for offline when ready:
        conditionallyAddPendingClient(new MainPageClient(), age == 0 && online);

        conditionallyAddPendingClient(new BecauseYouReadClient(), online);
        conditionallyAddPendingClient(new RandomClient(), age == 0);
    }
}
