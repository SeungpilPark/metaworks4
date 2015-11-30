package io.uengine.web.registe;

import io.uengine.common.repository.PersistentRepository;

public interface RegisteRepository extends PersistentRepository<Registe, Long> {

    public static final String NAMESPACE = RegisteRepository.class.getName();

    Registe selectByUserEmail(Registe registe);
}
