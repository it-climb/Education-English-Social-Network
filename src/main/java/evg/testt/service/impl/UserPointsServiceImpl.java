package evg.testt.service.impl;

import evg.testt.dao.UserPointsDao;
import evg.testt.model.UserPoints;
import evg.testt.service.UserPointsService;
import org.springframework.stereotype.Service;

@Service
public class UserPointsServiceImpl extends BaseService<UserPoints, UserPointsDao> implements UserPointsService {
}
