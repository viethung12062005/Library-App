package Library.backend.Request.DAO;


import Library.backend.Request.Model.Request;
import Library.backend.bookModel.Book;

import java.time.LocalDateTime;
import java.util.List;

public interface RequestDAO {

    void createBorrowRequest(Request request);
    List<Request> getMemberBorrowHistory(int memberID);
    void updateRequest(Request request);
    Request getRequestById(int requestID);
    void handleOverdueRequests();
    List<Request> getAllRequests();
    List<Request> getRequestsByMemberID(int memberID);
}