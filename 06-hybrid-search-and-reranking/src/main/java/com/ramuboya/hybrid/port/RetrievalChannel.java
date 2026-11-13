package com.ramuboya.hybrid.port;
import com.ramuboya.hybrid.domain.RankedPassage;
import java.util.List;
public interface RetrievalChannel { List<RankedPassage> search(String query, int limit); }
