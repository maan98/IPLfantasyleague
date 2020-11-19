package com.org.dxc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.dxc.model.Admin;
import com.org.dxc.model.Bidder;
import com.org.dxc.model.Leaderboard;
import com.org.dxc.model.MatchDetails;
import com.org.dxc.model.TeamDetails;
import com.org.dxc.service.IPLService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class WebController {
	
	@Autowired
	IPLService iplService;
	
	@Autowired
	HttpSession session;
	
	@GetMapping("/adminlogin/{userName}/{password}")
	public boolean adminLogin(@PathVariable String userName,@PathVariable String password) {
		Admin admin=iplService.adminLogin(userName,password);
		if(admin!=null) {
			session.setAttribute("username", admin.getUserName());
			return true;
		}
		else {
			return false;
		}
	}
	
	@PostMapping("/biddersignup")
	public Bidder bidderSignUp(@RequestBody Bidder bidder) {
		return iplService.bidderSignUp(bidder);
	}
	
	@GetMapping("/bidderlogin/{email}/{password}")
	public boolean bidderLogin(@PathVariable String email,@PathVariable String password) {
		Bidder bidder=iplService.bidderLogin(email,password);
		if(bidder!=null) {
			session.setAttribute("email", bidder.getEmail());
			session.setAttribute("id", bidder.getBidderId());
			System.out.println(session.getAttribute("id"));
			return true;
		}else {
			return false;
		}
	}
	
	@GetMapping("/teamdetails/{id}")
	public TeamDetails getTeamDetails(@PathVariable int id) {
		return iplService.getTeamDetails(id);
	}
	
	@GetMapping("/teamdetails/{name}")
	public TeamDetails getTeamDetailsByName(@PathVariable String name) {
		return iplService.getTeamDetailsByName(name);
	}
	
	@GetMapping("/teamdetails")
	public List<TeamDetails> getTeamDetails(){
		return iplService.getTeamDetails();
	}
	
	@GetMapping("/matchdetails/{id}")
	public MatchDetails getMatchDetails(@PathVariable int id) {
		return iplService.getMatchDetails(id);
	}
	
	@GetMapping("/leaderboard")
	public List<Leaderboard> getLeaderboard() {
		return iplService.getLeaderboard();
	}
	
	 @GetMapping("/leaderboard/{id}")
	    public Leaderboard getBidderById(@PathVariable int id) {
	        return iplService.bidderById(id);
	    }
	    
	@PostMapping(value="/leaderboard")
	public Leaderboard updateLeaderboard(@RequestBody Leaderboard leaderboard) {
	    return iplService.updateLeaderboard(leaderboard);
	}
	
	@PutMapping("/result")
	public MatchDetails resultDeclare(@RequestBody MatchDetails result) {
		return iplService.resultDeclare(result);
	}
	
	  @GetMapping("/pointstable")
	    public List<TeamDetails>getPointstable(){
	        return iplService.getPointstable();
	    }
	    @GetMapping("/pointstable/{id}")
	    public TeamDetails getPointstableById(@PathVariable int id) {
	        return iplService.pointstableById(id);
	    }
	    @PostMapping("/pointstable")
	    public TeamDetails updatePointstable(@RequestBody TeamDetails pointstable) {
	        return iplService.updatePointstable(pointstable);
	    }
	    
	    @GetMapping("/match")
	    public List<MatchDetails> getMatches(){
	        return iplService.getAllMatches();
	    }
	    @GetMapping("/match/{id}")
	    public MatchDetails getMatchById(@PathVariable int id) {
	        return iplService.MatchById(id);
	    }
	    @PutMapping("/match")
	    public MatchDetails updateTeam(@RequestBody MatchDetails md) {
	        return iplService.updateMatch(md);
	       
	    }
	    
	    @PostMapping("/newbid")
	    public Bidder newBid(@RequestBody Bidder bid) {
	    	return iplService.newBid(bid);
	    }
	    
	    @PostMapping("/cancelbid")
	    public Bidder cancelBid(@RequestBody Bidder cancelBidder) {
	    	return iplService.cancelBid(cancelBidder);
	    }
	    
	    @GetMapping("/logout")
	    public boolean logout() {
	    	session.invalidate();
	    	return true;
	    }
	
}
