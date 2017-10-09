package ru.cultserv.adv.yandex.direct.methods;

import ru.cultserv.adv.yandex.direct.models.AccountFilterParam;
import ru.cultserv.adv.yandex.direct.models.AccountManagementResponse;

/**
 * @author Sergey Zudin
 * @since 04.09.17.
 */
public interface AccountManagement {

    @DirectMethod(MethodName.AccountManagement)
    AccountManagementResponse get(AccountFilterParam param);

}
