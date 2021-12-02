from rest_framework import status, views
from rest_framework.response import Response
from authApp.models.user import User
from authApp.DictionaryUtils import Functions_Global
from rest_framework.permissions import IsAuthenticated

from authApp.serializers.userSerializer import UserSerializer


class UserUpdateView(views.APIView):

    permission_classes = (IsAuthenticated,)
    def put(self, request, *args, **kwargs):
        try:
            if  Functions_Global.is_Authenticated(request):
                userInstance = User.objects.filter(id=kwargs['pk']).first()
                serializer = UserSerializer(userInstance, data=request.data)
                serializer.is_valid(raise_exception=True)
                userInstance = serializer.save()
                return Response(serializer.data, status=status.HTTP_202_ACCEPTED)

        except Exception as ex:
            return Response(str(ex), status = status.HTTP_502_BAD_GATEWAY)