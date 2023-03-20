import java.util.*;

public class RecentlyPlayedStore {
    private int capacity;
    private Map<String, LinkedList<String>> store; // String: User ID, LinkedList: List of recently played songs

    public RecentlyPlayedStore(int capacity) {
        this.capacity = capacity;
        this.store = new HashMap<>();
    }

    public void addSong(String userId, String song) {
        if (!store.containsKey(userId)) {
            store.put(userId, new LinkedList<>());
        }
        LinkedList<String> songList = store.get(userId);
        songList.addFirst(song); // Adding the newly played song to the beginning of the list
        if (songList.size() > capacity) {
            songList.removeLast(); // Removing the least recently played song
        }
    }

    public List<String> getRecentlyPlayedSongs(String userId) {
        if (!store.containsKey(userId)) {
            return Collections.emptyList(); // User has not played any songs yet
        }
        return store.get(userId); // Returns the list of recently played songs for the given user
    }
}