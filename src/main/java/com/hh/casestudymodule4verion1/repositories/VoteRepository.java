package com.hh.casestudymodule4verion1.repositories;

import com.hh.casestudymodule4verion1.models.Account;
import com.hh.casestudymodule4verion1.models.Book;
import com.hh.casestudymodule4verion1.models.Vote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface VoteRepository extends CrudRepository<Vote,Long> {
    int countVotesByBook_Id(Long book_id);
    List<Vote> findVotesByBook(Book book);

    Optional<Vote> findVotesByBookAndAccount(Book book, Account account);


}
