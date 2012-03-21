package ebiz.dao.hibernate;

import java.util.List;

import ebiz.dao.inf.IProviderDAO;
import ebiz.dto.account.provider.Provider;

public class ProviderDAO implements IProviderDAO {

    @Override
    public boolean saveProvider(Provider provider) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isProvider(String id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Provider getProviderById(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Provider> getProviderAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Provider> getProviderByName(String value) {
        // TODO Auto-generated method stub
        return null;
    }

}
