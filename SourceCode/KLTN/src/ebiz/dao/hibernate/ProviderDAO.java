package ebiz.dao.hibernate;

import java.util.List;

import ebiz.dao.inf.IProviderDAO;
import ebiz.dto.account.provider.Provider;

public class ProviderDAO implements IProviderDAO {

    @Override
    public boolean saveProvider(Provider provider) {
        return HibernateHelper.saveObject(provider);
    }

    @Override
    public boolean isProvider(String id) {
        return HibernateHelper.isObject(Provider.class, id);
    }

    @Override
    public Provider getProviderById(String id) {
        return (Provider) HibernateHelper.getObjectById(Provider.class, id);
    }

    @Override
    public List<Provider> getProviderAll() {
        return (List<Provider>) HibernateHelper.getObjectList(Provider.class);
    }

    @Override
    public List<Provider> getProviderByName(String value) {
        return (List<Provider>) HibernateHelper.getObjectListByValue(Provider.class, "providerName", value);
    }

}
