from rest_framework import status, views
from rest_framework.response import Response
from authApp.models.user import User

from authApp.serializers import UserSerializer

class UserListAllView(views.APIView):

    def get(self, request, *args, **kwargs):
     
        try:
            users = User.objects.all()
            userSerializer = UserSerializer(users, many= True)
            return Response(userSerializer.data, status = status.HTTP_200_OK)

        except Exception as ex:
            return Response(str(ex), status = status.HTTP_502_BAD_GATEWAY)