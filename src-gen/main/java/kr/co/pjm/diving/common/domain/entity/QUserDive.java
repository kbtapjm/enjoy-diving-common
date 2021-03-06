package kr.co.pjm.diving.common.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserDive is a Querydsl query type for UserDive
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserDive extends EntityPathBase<UserDive> {

    private static final long serialVersionUID = 1876006268L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserDive userDive = new QUserDive("userDive");

    public final kr.co.pjm.diving.common.domain.entity.common.QCommonEntity _super = new kr.co.pjm.diving.common.domain.entity.common.QCommonEntity(this);

    public final StringPath diveGroup = createString("diveGroup");

    public final StringPath diveLevel = createString("diveLevel");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final StringPath signature = createString("signature");

    public final StringPath team = createString("team");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDate = _super.updateDate;

    public final QUser user;

    public QUserDive(String variable) {
        this(UserDive.class, forVariable(variable), INITS);
    }

    public QUserDive(Path<? extends UserDive> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserDive(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserDive(PathMetadata metadata, PathInits inits) {
        this(UserDive.class, metadata, inits);
    }

    public QUserDive(Class<? extends UserDive> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

