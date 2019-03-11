package kr.co.pjm.diving.common.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserLoginLog is a Querydsl query type for UserLoginLog
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserLoginLog extends EntityPathBase<UserLoginLog> {

    private static final long serialVersionUID = -1122755933L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserLoginLog userLoginLog = new QUserLoginLog("userLoginLog");

    public final kr.co.pjm.diving.common.domain.entity.common.QCommonEntity _super = new kr.co.pjm.diving.common.domain.entity.common.QCommonEntity(this);

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDate = _super.updateDate;

    public final QUser user;

    public QUserLoginLog(String variable) {
        this(UserLoginLog.class, forVariable(variable), INITS);
    }

    public QUserLoginLog(Path<? extends UserLoginLog> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserLoginLog(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserLoginLog(PathMetadata metadata, PathInits inits) {
        this(UserLoginLog.class, metadata, inits);
    }

    public QUserLoginLog(Class<? extends UserLoginLog> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

