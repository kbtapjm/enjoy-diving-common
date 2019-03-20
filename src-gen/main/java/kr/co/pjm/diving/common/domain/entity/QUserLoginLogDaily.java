package kr.co.pjm.diving.common.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserLoginLogDaily is a Querydsl query type for UserLoginLogDaily
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserLoginLogDaily extends EntityPathBase<UserLoginLogDaily> {

    private static final long serialVersionUID = -948043466L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserLoginLogDaily userLoginLogDaily = new QUserLoginLogDaily("userLoginLogDaily");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> loginCount = createNumber("loginCount", Long.class);

    public final DatePath<java.time.LocalDate> loginDate = createDate("loginDate", java.time.LocalDate.class);

    public final QUser user;

    public QUserLoginLogDaily(String variable) {
        this(UserLoginLogDaily.class, forVariable(variable), INITS);
    }

    public QUserLoginLogDaily(Path<? extends UserLoginLogDaily> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserLoginLogDaily(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserLoginLogDaily(PathMetadata metadata, PathInits inits) {
        this(UserLoginLogDaily.class, metadata, inits);
    }

    public QUserLoginLogDaily(Class<? extends UserLoginLogDaily> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

