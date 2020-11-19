package com.org.dxc.service;

import java.util.List;

import com.org.dxc.model.Admin;
import com.org.dxc.model.Bidder;
import com.org.dxc.model.Leaderboard;
import com.org.dxc.model.MatchDetails;
import com.org.dxc.model.TeamDetails;
import com.org.dxc.model.Tournament;

public interface IPLService {

	public Admin adminLogin(String userName,String password);

	public Bidder bidderSignUp(Bidder bidder);

	public Bidder bidderLogin(String email,String password);

	public TeamDetails getTeamDetails(int id);
	
	public TeamDetails getTeamDetailsByName(String name);

	public MatchDetails getMatchDetails(int id);

	public List<Leaderboard> getLeaderboard();

	public MatchDetails resultDeclare(MatchDetails result);

	public List<TeamDetails> getTeamDetails();

	public Leaderboard bidderById(int id);

	public Leaderboard updateLeaderboard(Leaderboard leaderboard);

	public List<TeamDetails> getPointstable();

	public TeamDetails pointstableById(int id);

	public TeamDetails updatePointstable(TeamDetails pointstable);

	public List<MatchDetails> getAllMatches();

	public MatchDetails MatchById(int id);

	public MatchDetails updateMatch(MatchDetails t);

	public Bidder newBid(Bidder bid);

	public Bidder cancelBid(Bidder cancelBidder);


}
