package com.org.dxc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.dxc.dao.AdminRepository;
import com.org.dxc.dao.BidderRepository;
import com.org.dxc.dao.LeaderboardRepository;
import com.org.dxc.dao.MatchDetailsRepository;
import com.org.dxc.dao.TeamDetailsRepository;
import com.org.dxc.dao.TournamentRepository;
import com.org.dxc.model.Admin;
import com.org.dxc.model.Bidder;
import com.org.dxc.model.Leaderboard;
import com.org.dxc.model.MatchDetails;
import com.org.dxc.model.TeamDetails;
import com.org.dxc.model.Tournament;

@Service
public class IPLServiceImp implements IPLService {
	
@Autowired
AdminRepository adminRepository;

@Autowired
BidderRepository bidderRepository;

@Autowired
LeaderboardRepository leaderboardRepository;

@Autowired
MatchDetailsRepository matchDetailsRepository;

@Autowired
TeamDetailsRepository teamDetailsRepository;

@Autowired
TournamentRepository tournamentRepository;

@Override
public Admin adminLogin(String userName,String password) {
	// TODO Auto-generated method stub
	Admin admin=adminRepository.findByUserName(userName,password);
	if(admin!=null) {
    	return admin;
    }
    return null;
}

@Override
public Bidder bidderSignUp(Bidder bidder) {
	// TODO Auto-generated method stub
	return bidderRepository.save(bidder);
}

@Override
public Bidder bidderLogin(String email,String password) {
	// TODO Auto-generated method stub
	Bidder bidder=bidderRepository.getBidderByEmailAndPassword(email, password);
	System.out.println(bidder);
	if(bidder!=null) {
		return bidder;
	}else {
		return null;
	}
}

@Override
public TeamDetails getTeamDetails(int id) {
	// TODO Auto-generated method stub
	return teamDetailsRepository.findById(id).get();
}

@Override
public MatchDetails getMatchDetails(int id) {
	// TODO Auto-generated method stub
	return matchDetailsRepository.findById(id).get();
}

@Override
public List<Leaderboard> getLeaderboard() {
	// TODO Auto-generated method stub
	return leaderboardRepository.findAll();
}

@Override
public MatchDetails resultDeclare(MatchDetails result) {
	// TODO Auto-generated method stub
	MatchDetails declareResult=matchDetailsRepository.findById(result.getMatchId()).get();
	declareResult.setWinner(result.getWinner());
	return matchDetailsRepository.save(declareResult);
}

@Override
public List<TeamDetails> getTeamDetails() {
	// TODO Auto-generated method stub
	return teamDetailsRepository.getPointsTable();
}

@Override
public Leaderboard bidderById(int id) {
	// TODO Auto-generated method stub
	return leaderboardRepository.findById(id).get();
}

@Override
public Leaderboard updateLeaderboard(Leaderboard leaderboard) {
	// TODO Auto-generated method stub
	Leaderboard toUpdate=leaderboardRepository.findById(leaderboard.getId()).get();
	   toUpdate.setBidderPoints(leaderboard.getBidderPoints());
       toUpdate.setBidsWon(leaderboard.getBidsWon());
       return leaderboardRepository.save(toUpdate);
}

public List<TeamDetails> getPointstable() {
    // TODO Auto-generated method stub
    return teamDetailsRepository.findAll();
}
public TeamDetails pointstableById(int id) {
    // TODO Auto-generated method stub
    return teamDetailsRepository.findById(id).get();
}




public TeamDetails updatePointstable(TeamDetails pointstable) {
    // TODO Auto-generated method stub
	TeamDetails toUpdate=teamDetailsRepository.findById(pointstable.getTeamId()).get();
    toUpdate.setPoints(pointstable.getPoints());
    toUpdate.setRanking(pointstable.getRanking());
    return teamDetailsRepository.save(toUpdate);
}

public List<MatchDetails> getAllMatches() {
    
    return matchDetailsRepository.findAll();
}
public MatchDetails MatchById(int id) {
    return matchDetailsRepository.findById(id).get();
    
}



public MatchDetails updateMatch(MatchDetails t) {
    
    MatchDetails toUpdate =matchDetailsRepository.findById(t.getMatchId()).get();
    toUpdate.setDelay(t.getDelay());
    toUpdate.setWinner(t.getWinner());
    toUpdate.setStatus(t.getStatus());
    return matchDetailsRepository.save(toUpdate);
}

@Override
public TeamDetails getTeamDetailsByName(String name) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Bidder newBid(Bidder bid) {
	// TODO Auto-generated method stub
	Bidder bidder=bidderRepository.getBidderByEmail(bid.getEmail());
	bidder.setOpinion(bid.getOpinion());
	return bidderRepository.save(bidder);
}

@Override
public Bidder cancelBid(Bidder cancelBidder) {
	// TODO Auto-generated method stub
	Bidder bidder=bidderRepository.getBidderByEmail(cancelBidder.getEmail());
	bidder.setOpinion(cancelBidder.getOpinion());
	return bidderRepository.save(bidder);
}


}
