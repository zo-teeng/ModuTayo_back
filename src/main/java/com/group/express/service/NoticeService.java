package com.group.express.service;

import com.group.express.domain.Notice;
import com.group.express.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {
    private final NoticeRepository noticeRepository;

    @Autowired
    public NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    // 공지사항 목록 조회
    public List<Notice> getAllNotices() {
        return noticeRepository.findAll();
    }

    // 공지사항 상세 조회
    public Notice getNoticeById(Long num) {
        return noticeRepository.findById(num).orElse(null);
    }

    // 공지사항 등록
    public Notice createNotice(Notice notice) {
        return noticeRepository.save(notice);
    }

    // 공지사항 수정
    public Notice updateNotice(Notice notice) {
        return noticeRepository.save(notice);
    }

    // 공지사항 삭제
    public void deleteNotice(Long num) {
        noticeRepository.deleteById(num);
    }
}