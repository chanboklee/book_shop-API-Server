package com.book.shop.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.book.shop.domain.Address;
import com.book.shop.domain.Member;
import com.book.shop.dto.MemberDto;
import com.book.shop.request.CreateMemberRequest;
import com.book.shop.response.AllMemberResponse;
import com.book.shop.response.CreateMemberResponse;
import com.book.shop.response.OneMemberResponse;
import com.book.shop.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberApiController {
	
	private final MemberService memberService;
	
	@GetMapping("/members/{id}")
	public ResponseEntity<OneMemberResponse> getMember(@PathVariable(name = "id") Long memberId) {
		Member findMember = memberService.getMember(memberId);
		return ResponseEntity.ok().body(new OneMemberResponse(findMember.getName()));
	}
	
	@GetMapping("/members")
	public ResponseEntity<AllMemberResponse> getMembers() {
		
		List<MemberDto> collect = memberService.getMembers().stream().map(m -> new MemberDto(m.getId(), m.getName()))
														    	     .collect(Collectors.toList());
		
		return ResponseEntity.ok().body(new AllMemberResponse(collect.size(), collect));
	}
	
	
	@PostMapping("/members")
	public ResponseEntity<CreateMemberResponse> saveMember(@RequestBody @Valid CreateMemberRequest createMemberRequest) {
		
		Address address = Address.builder().city(createMemberRequest.getCity())
										   .zipcode(createMemberRequest.getZipcode())
										   .street(createMemberRequest.getStreet())
										   .build();
		
		Member member = Member.builder().name(createMemberRequest.getName())
										.userId(createMemberRequest.getUserId())
										.userPw(createMemberRequest.getUserPw())
										.address(address)
										.build();
		
		memberService.saveMember(member);
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/members").toUriString());
		return ResponseEntity.created(uri).body(new CreateMemberResponse(member.getId()));
	}
}
